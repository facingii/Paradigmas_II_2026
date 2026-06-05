package mx.uv.fiee.iinf.springboot.AdventureWorksClient.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ProductCategory", schema = "Production")
public class ProductCategory {

    @Id
    @Column(name = "ProductCategoryID")
    private int productCategoryID;

    @Column (name = "Name")
    private String name;

    @Column (name = "rowguid")
    private UUID rowguid;

    @Column (name = "ModifiedDate")
    private LocalDateTime modifiedDate;

    public int getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(int productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getRowguid() {
        return rowguid;
    }

    public void setRowguid(UUID rowguid) {
        this.rowguid = rowguid;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


}