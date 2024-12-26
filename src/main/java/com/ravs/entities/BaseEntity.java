package com.ravs.entities;



import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/*commend
 * This is the base entity class which is extended by all the entities in the
 * project. It contains the common fields that are used by all the entities.
 * 
 * @version 1.0
 * @since 1.0
 */
@MappedSuperclass
public abstract class BaseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    private String created_date;

    private String lastmodified_date;

    private int created_by_id;

    private int last_modified_by_id;
    

    public int getCreated_by_id() {
        return created_by_id;
    }

    public void setCreated_by_id(int created_by_id) {
        this.created_by_id = created_by_id;
    }

    public int getLast_modified_by_id() {
        return last_modified_by_id;
    }

    public void setLast_modified_by_id(int last_modified_by_id) {
        this.last_modified_by_id = last_modified_by_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getLastmodified_date() {
        return lastmodified_date;
    }

    public void setLastmodified_date(String lastmodified_date) {
        this.lastmodified_date = lastmodified_date;
    }
    
    
}
