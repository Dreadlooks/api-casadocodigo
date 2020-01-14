package br.com.gabriels.apicasadocodigo.shared.fileupload;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorage {

    String upload(MultipartFile file);
}
