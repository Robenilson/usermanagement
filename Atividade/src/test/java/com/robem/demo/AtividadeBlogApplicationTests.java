package com.robem.demo;

import com.robem.demo.core.ports.IPublicationServece;
import com.robem.demo.adapter.DTO.RecordPublication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AtividadeBlogApplicationTests {
	@Autowired
	IPublicationServece iPublicationServece;

	@Test
	void contextLoads() {
		RecordPublication recordPublication= new  RecordPublication("sdfsdf","sdfsdf","dfsdfsd");
		iPublicationServece.save( recordPublication);
	}

	@Test
	void ListEmail() {
		RecordEmail recordEmail= new RecordEmail("sdfsdf");
	iPublicationServece.listPublication(recordEmail);
	}

}
