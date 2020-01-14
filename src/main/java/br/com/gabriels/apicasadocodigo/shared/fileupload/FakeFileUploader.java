package br.com.gabriels.apicasadocodigo.shared.fileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FakeFileUploader implements FileStorage {

    private static final Logger LOG = LoggerFactory.getLogger(FakeFileUploader.class);

    @Override
    public String upload(MultipartFile file) {
        LOG.info("Enviando arquivo para o s3....");
        return "https://s3.amazon/bucket_name/" + file.getOriginalFilename();
    }
}
