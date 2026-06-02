package mx.uv.fiee.iinf.springboot.AdventureWorksClient.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table (name = "Product", schema = "Production")
public class Product {
    @Id
    @Column(name = "ProductID")
    private long productID;

    @Column(name = "Name")
    private String name;

    @Column(name = "ProductNumber")
    private String productNumber;

    @Column(name = "Color")
    private String color;

    @Column(name = "MakeFlag")
    private boolean makeFlag;

    @Column(name = "FinishedGoodsFlag")
    private boolean finishedGoodsFlag;

    @Column(name = "SafetyStockLevel")
    private String safetyStockLevel;

    @Column(name = "ReorderPoint")
    private String reorderPoint;

    @Column(name = "StandardCost")
    private String standardCost;

    @Column(name = "ListPrice")
    private BigDecimal listPrice;

    @Column(name = "Size")
    private String size;

    @Column(name = "SizeUnitMeasureCode")
    private String sizeUnitMeasureCode;

    @Column(name = "WeightUnitMeasureCode")
    private String weightUnitMeasureCode;

    @Column(name = "Weight")
    private String weight;

    @Column(name = "DaysToManufacture")
    private String daysToManufacture;

    @Column(name = "ProductLine")
    private String productLine;

    @Column(name = "Class")
    private String productClass;

    @Column(name = "Style")
    private String style;

    @Column(name = "ProductSubcategoryID")
    private Integer productSubcategoryID;

    @Column(name = "ProductModelID")
    private Integer productModelID;

    @Column(name = "SellStartDate")
    private String sellStartDate;

    @Column(name = "SellEndDate")
    private String sellEndDate;

    @Column(name = "DiscontinuedDate")
    private String discontinuedDate;

    @Column(name = "rowguid")
    private UUID rowguid;

    @Column(name = "ModifiedDate")
    private String modifiedDate;

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isMakeFlag() {
        return makeFlag;
    }

    public void setMakeFlag(boolean makeFlag) {
        this.makeFlag = makeFlag;
    }

    public boolean isFinishedGoodsFlag() {
        return finishedGoodsFlag;
    }

    public void setFinishedGoodsFlag(boolean finishedGoodsFlag) {
        this.finishedGoodsFlag = finishedGoodsFlag;
    }

    public String getSafetyStockLevel() {
        return safetyStockLevel;
    }

    public void setSafetyStockLevel(String safetyStockLevel) {
        this.safetyStockLevel = safetyStockLevel;
    }

    public String getReorderPoint() {
        return reorderPoint;
    }

    public void setReorderPoint(String reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    public String getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(String standardCost) {
        this.standardCost = standardCost;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeUnitMeasureCode() {
        return sizeUnitMeasureCode;
    }

    public void setSizeUnitMeasureCode(String sizeUnitMeasureCode) {
        this.sizeUnitMeasureCode = sizeUnitMeasureCode;
    }

    public String getWeightUnitMeasureCode() {
        return weightUnitMeasureCode;
    }

    public void setWeightUnitMeasureCode(String weightUnitMeasureCode) {
        this.weightUnitMeasureCode = weightUnitMeasureCode;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDaysToManufacture() {
        return daysToManufacture;
    }

    public void setDaysToManufacture(String daysToManufacture) {
        this.daysToManufacture = daysToManufacture;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductClass() {
        return productClass;
    }

    public void setProductClass(String productClass) {
        this.productClass = productClass;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Integer getProductSubcategoryID() {
        return productSubcategoryID;
    }

    public void setProductSubcategoryID(Integer productSubcategoryID) {
        this.productSubcategoryID = productSubcategoryID;
    }

    public Integer getProductModelID() {
        return productModelID;
    }

    public void setProductModelID(Integer productModelID) {
        this.productModelID = productModelID;
    }

    public String getSellStartDate() {
        return sellStartDate;
    }

    public void setSellStartDate(String sellStartDate) {
        this.sellStartDate = sellStartDate;
    }

    public String getSellEndDate() {
        return sellEndDate;
    }

    public void setSellEndDate(String sellEndDate) {
        this.sellEndDate = sellEndDate;
    }

    public String getDiscontinuedDate() {
        return discontinuedDate;
    }

    public void setDiscontinuedDate(String discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
    }

    public UUID getRowguid() {
        return rowguid;
    }

    public void setRowguid(UUID rowguid) {
        this.rowguid = rowguid;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

