package bip.leitorvenda.com.br.service;

import com.amazonaws.services.s3.model.S3ObjectInputStream;

import bip.leitorvenda.com.br.domain.FileSave;
import bip.leitorvenda.com.br.gateway.json.FileUUIDJson;
import bip.leitorvenda.com.br.service.file.GetFileSaveService;
import bip.leitorvenda.com.br.service.file.UpdateStatusFileSaveService;
import bip.leitorvenda.com.br.service.s3.S3Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class ReaderFileService {

    @Autowired
    private GetFileSaveService getFileSaveService;

    @Autowired
    private S3Service s3Service;

    @Autowired
    private ReaderFileLineService readerFileLineService;

    @Autowired
    private UpdateStatusFileSaveService updateStatusFileSaveService;

    public void execute(FileUUIDJson fileUUIDJson) throws IOException {
        FileSave fileSave = getFileSaveService.execute(UUID.fromString(fileUUIDJson.getUuid()));
        S3ObjectInputStream s3ObjectInputStream = s3Service.execute(fileSave.getPath());

        readerFileLineService.execute(s3ObjectInputStream);

        updateStatusFileSaveService.execute(
                fileSave.getId()
        );
    }

}
