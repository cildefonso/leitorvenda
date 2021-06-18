package bip.leitorvenda.com.br.service.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bip.leitorvenda.com.br.domain.FileSave;
import bip.leitorvenda.com.br.gateway.repository.FileSaveRepository;

import java.util.UUID;

@Service
public class GetFileSaveService {

    @Autowired
    private FileSaveRepository fileSaveRepository;

    public FileSave execute(UUID uuid) {
        return fileSaveRepository.findById(uuid).get();
    }
}
