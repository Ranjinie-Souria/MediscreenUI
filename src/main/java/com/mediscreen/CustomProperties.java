package com.mediscreen;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "com.mediscreen")
public class CustomProperties {

    private String apiPatient;
    private String apiAssignement;
    private String apiNote;
    private String keyApiNote;
    
    
	public String getKeyApiNote() {
		return keyApiNote;
	}
	public void setKeyApiNote(String keyApiNote) {
		this.keyApiNote = keyApiNote;
	}
	public String getApiPatient() {
		return apiPatient;
	}
	public void setApiPatient(String apiPatient) {
		this.apiPatient = apiPatient;
	}
	public String getApiAssignement() {
		return apiAssignement;
	}
	public void setApiAssignement(String apiAssignement) {
		this.apiAssignement = apiAssignement;
	}
	public String getApiNote() {
		return apiNote;
	}
	public void setApiNote(String apiNote) {
		this.apiNote = apiNote;
	}


    
    
    

}