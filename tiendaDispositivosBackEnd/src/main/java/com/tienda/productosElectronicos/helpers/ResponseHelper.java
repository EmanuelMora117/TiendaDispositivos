package com.tienda.productosElectronicos.helpers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


@Service
public class ResponseHelper {
	
	public ResponseEntity<ObjectNode> returnLogProcess(String answer){
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
		
		objectNode.put("answer", answer);
		
		return ResponseEntity.ok(objectNode);	
	}
	
	public ResponseEntity<ObjectNode> returnLogProcess(String answer, String tipo){
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
		
		objectNode.put("answer", answer);
	    objectNode.put("tipo", tipo);
		
		return ResponseEntity.ok(objectNode);	
	}
}
