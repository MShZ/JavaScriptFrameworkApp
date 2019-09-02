package com.etnetera.hr.service;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.model.ResponseModel;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JavaScriptFrameworkService {

    private static final Log LOG = LogFactory.getLog(JavaScriptFrameworkService.class);

    public Iterable<JavaScriptFramework> findAll(JavaScriptFrameworkRepository repository) {
        return repository.findAll();
    }

    public Iterable<JavaScriptFramework> findByName(JavaScriptFrameworkRepository repository, String name) {
        return repository.findByName(name);
    }

    public Iterable<JavaScriptFramework> findByVersion(JavaScriptFrameworkRepository repository, String version) {
        return repository.findByVersion(version);
    }

    public ResponseEntity<ResponseModel> createFramework(JavaScriptFrameworkRepository repository, JavaScriptFramework model) {
        LOG.info("CREATE");
        JavaScriptFramework newFramework = repository.save(model);
        return new ResponseEntity<>(new ResponseModel(newFramework.getId(), 0 , ""), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> updateFramework(JavaScriptFrameworkRepository repository, JavaScriptFramework model) {
        if (!repository.existsById(model.getId())) {
            LOG.error("UPDATE-ERROR");

            ResponseModel response = new ResponseModel(model.getId(), 1, "id not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        LOG.info("UPDATE");
        Optional<JavaScriptFramework> updatedFramework = repository.findById(model.getId())
                .map(framework -> {
                    framework.setName(model.getName());
                    framework.setDeprecationDate(model.getDeprecationDate());
                    framework.setHypeLevel(model.getHypeLevel());
                    framework.setVersion(model.getVersion());
                    return repository.save(framework);
                });

        return new ResponseEntity<>(new ResponseModel(updatedFramework.get().getId(), 0 , ""), HttpStatus.OK);
    }

    public ResponseEntity<ResponseModel> deleteFramework(JavaScriptFrameworkRepository repository, Long id) {
        if (!repository.existsById(id)) {
            LOG.error("DELETE-ERROR");

            ResponseModel response = new ResponseModel(id, 1, "id not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
        LOG.info("DELETE");

        return new ResponseEntity<>(new ResponseModel(0L,0, ""), HttpStatus.OK);
    }
}
