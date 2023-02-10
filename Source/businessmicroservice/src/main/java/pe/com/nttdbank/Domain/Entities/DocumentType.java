package pe.com.nttdbank.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class DocumentType {
    @Id
    @GeneratedValue
    private Long documentTypeCode;
    private String documentTypeName;

    public DocumentType() {
    }

    public Long getDocumentTypeCode() {
        return documentTypeCode;
    }

    public void setDocumentTypeCode(Long documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }

}
