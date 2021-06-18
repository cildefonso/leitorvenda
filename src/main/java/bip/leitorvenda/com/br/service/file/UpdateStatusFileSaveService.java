package bip.leitorvenda.com.br.service.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bip.leitorvenda.com.br.enums.FileStatusEnum;
import bip.leitorvenda.com.br.gateway.repository.FileSaveRepository;

import java.util.UUID;

@Service
public class UpdateStatusFileSaveService {

    @Autowired
    private FileSaveRepository fileSaveRepository;

    @Transactional
    public void execute(UUID uuid) {
        fileSaveRepository.updateStatus(FileStatusEnum.PROCESSADO.toString(), uuid);
    }
}
