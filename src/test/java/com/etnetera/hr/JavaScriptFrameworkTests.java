package com.etnetera.hr;

import com.etnetera.hr.controller.JavaScriptFrameworkController;
import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.model.ResponseModel;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.stream.StreamSupport;


/**
 * Class used for Spring Boot/MVC based tests.
 * 
 * @author Etnetera
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaScriptFrameworkTests {

    @Autowired
    private JavaScriptFrameworkController javaScriptFrameworkController;

    @Autowired
    private JavaScriptFrameworkRepository javaScriptFrameworkRepository;

    @Test
    @Before
	public void whenCreate_thenReturnId() {
        //given
        String deprecationDate = "2020-10-01";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        JavaScriptFramework newFramework = new JavaScriptFramework("Angular");
        newFramework.setVersion("1.0.0");
        newFramework.setDeprecationDate(LocalDate.parse(deprecationDate, formatter));
        newFramework.setHypeLevel(1);

        //when
        ResponseEntity<ResponseModel> response = javaScriptFrameworkController.create(newFramework);

        //then
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertNotNull(response.getBody().getRecordId());
    }

    @Test
    public void whenFindAll_thenCountItems() {
	    //given

        //when
        Iterable<JavaScriptFramework> response = javaScriptFrameworkController.findAll();

        //then
        long count = StreamSupport.stream(response.spliterator(), false).count();
        if (count == 0) {
            Assert.fail();
        }
    }

    @Test
    public void whenFindByName_thenEqualsItemsName() {
	    //given
        String checkNameIn = "Angular";

        //when
        Iterable<JavaScriptFramework> response = javaScriptFrameworkController.findByName(checkNameIn);

        //then
        long count = StreamSupport.stream(response.spliterator(), false).count();
        if (count == 0) {
            Assert.fail();
        } else {
            StreamSupport.stream(response.spliterator(), false).forEach((item) -> {
                String checkNameOut = item.getName();
                Assert.assertEquals(checkNameIn, checkNameOut);
            });
        }
    }

    @Test
    public void whenFindByVersion_thenEqualsItemsVersion() {
        //given
        String checkVersionIn = "1.0.0";

        //when
        Iterable<JavaScriptFramework> response = javaScriptFrameworkController.findByVersion(checkVersionIn);

        //then
        long count = StreamSupport.stream(response.spliterator(), false).count();
        if (count == 0) {
            Assert.fail();
        } else {
            StreamSupport.stream(response.spliterator(), false).forEach((item) -> {
                String checkVersionOut = item.getVersion();
                Assert.assertEquals(checkVersionIn, checkVersionOut);
            });
        }
    }

    @Test
    public void whenUpdate_thenEqualsItemsNewParams() {
        //given
        Optional<JavaScriptFramework> updatedFramework = javaScriptFrameworkRepository.findById(2L);
        updatedFramework.get().setVersion("2.0.0");
        updatedFramework.get().setHypeLevel(10);

        //when
        ResponseEntity<ResponseModel> response = javaScriptFrameworkController.update(updatedFramework.get());

        //then
        Optional<JavaScriptFramework> findItem = javaScriptFrameworkRepository.findById(2L);

        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals(findItem.get().getVersion(), updatedFramework.get().getVersion());
        Assert.assertEquals(findItem.get().getHypeLevel(), updatedFramework.get().getHypeLevel());
    }

    @Test
    public void whenDelete_thenEqualsItem() {
        //given
        Long id = 1L;

        //when
        ResponseEntity<ResponseModel> response = javaScriptFrameworkController.delete(id);

        //then
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }


}
