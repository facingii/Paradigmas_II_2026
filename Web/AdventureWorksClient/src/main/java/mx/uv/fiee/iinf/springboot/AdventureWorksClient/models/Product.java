package mx.uv.fiee.iinf.springboot.AdventureWorksClient.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Product {
    private int productId;
    private String name;
    private String productNumber;
    private String color;
    private BigDecimal standardCost;
    private BigDecimal listPrice;
    private String size;
    private String sizeUnitMeasureCode;
    private String weightUnitMeasureCode;
    private BigDecimal weight;
    private int safetyStockLevel;
    private int reorderPoint;
    private LocalDate sellStartDate;
    private LocalDate sellEndDate;
    private LocalDate discontinuedDate;
    private String productLine;
    private String classCode;
    private String style;
    private int productSubcategoryId;
    private int productModelId;

    public Product() {}

    public Product(int productId, String name, String productNumber) {
        this.productId = productId;
        this.name = name;
        this.productNumber = productNumber;
    }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getProductNumber() { return productNumber; }
    public void setProductNumber(String productNumber) { this.productNumber = productNumber; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public BigDecimal getStandardCost() { return standardCost; }
    public void setStandardCost(BigDecimal standardCost) { this.standardCost = standardCost; }

    public BigDecimal getListPrice() { return listPrice; }
    public void setListPrice(BigDecimal listPrice) { this.listPrice = listPrice; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public String getSizeUnitMeasureCode() { return sizeUnitMeasureCode; }
    public void setSizeUnitMeasureCode(String sizeUnitMeasureCode) { this.sizeUnitMeasureCode = sizeUnitMeasureCode; }

    public String getWeightUnitMeasureCode() { return weightUnitMeasureCode; }
    public void setWeightUnitMeasureCode(String weightUnitMeasureCode) { this.weightUnitMeasureCode = weightUnitMeasureCode; }

    public BigDecimal getWeight() { return weight; }
    public void setWeight(BigDecimal weight) { this.weight = weight; }

    public int getSafetyStockLevel() { return safetyStockLevel; }
    public void setSafetyStockLevel(int safetyStockLevel) { this.safetyStockLevel = safetyStockLevel; }

    public int getReorderPoint() { return reorderPoint; }
    public void setReorderPoint(int reorderPoint) { this.reorderPoint = reorderPoint; }

    public LocalDate getSellStartDate() { return sellStartDate; }
    public void setSellStartDate(LocalDate sellStartDate) { this.sellStartDate = sellStartDate; }

    public LocalDate getSellEndDate() { return sellEndDate; }
    public void setSellEndDate(LocalDate sellEndDate) { this.sellEndDate = sellEndDate; }

    public LocalDate getDiscontinuedDate() { return discontinuedDate; }
    public void setDiscontinuedDate(LocalDate discontinuedDate) { this.discontinuedDate = discontinuedDate; }

    public String getProductLine() { return productLine; }
    public void setProductLine(String productLine) { this.productLine = productLine; }

    public String getClassCode() { return classCode; }
    public void setClassCode(String classCode) { this.classCode = classCode; }

    public String getStyle() { return style; }
    public void setStyle(String style) { this.style = style; }

    public int getProductSubcategoryId() { return productSubcategoryId; }
    public void setProductSubcategoryId(int productSubcategoryId) { this.productSubcategoryId = productSubcategoryId; }

    public int getProductModelId() { return productModelId; }
    public void setProductModelId(int productModelId) { this.productModelId = productModelId; }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", listPrice=" + listPrice +
                '}';
    }
}
