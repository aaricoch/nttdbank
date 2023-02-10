package pe.com.nttdbank.Domain.Entities;

import java.util.Date;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity extends PanacheEntityBase {
    public int State;
    public int AuditCreateUser;
    public Date AuditCreateDate;
    public int AuditUpdateUser;
    public Date AuditUpdateDate;
    public int AuditDeleteUser;
    public Date AuditDeleteDate;

    public int getState() {
        return State;
    }

    public void setState(int state) {
        State = state;
    }

    public int getAuditCreateUser() {
        return AuditCreateUser;
    }

    public void setAuditCreateUser(int auditCreateUser) {
        AuditCreateUser = auditCreateUser;
    }

    public Date getAuditCreateDate() {
        return AuditCreateDate;
    }

    public void setAuditCreateDate(Date auditCreateDate) {
        AuditCreateDate = auditCreateDate;
    }

    public int getAuditUpdateUser() {
        return AuditUpdateUser;
    }

    public void setAuditUpdateUser(int auditUpdateUser) {
        AuditUpdateUser = auditUpdateUser;
    }

    public Date getAuditUpdateDate() {
        return AuditUpdateDate;
    }

    public void setAuditUpdateDate(Date auditUpdateDate) {
        AuditUpdateDate = auditUpdateDate;
    }

    public int getAuditDeleteUser() {
        return AuditDeleteUser;
    }

    public void setAuditDeleteUser(int auditDeleteUser) {
        AuditDeleteUser = auditDeleteUser;
    }

    public Date getAuditDeleteDate() {
        return AuditDeleteDate;
    }

    public void setAuditDeleteDate(Date auditDeleteDate) {
        AuditDeleteDate = auditDeleteDate;
    }
}
