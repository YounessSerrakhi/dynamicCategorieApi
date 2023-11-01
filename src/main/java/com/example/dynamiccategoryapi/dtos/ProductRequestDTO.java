package com.example.dynamiccategoryapi.dtos;

import java.util.Map;

public class ProductRequestDTO {
        private String productName;
        private Integer typeId;
       private Map<Integer, Object> characteristics;
       private byte[] image;

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Integer getTypeId() {
            return typeId;
        }

        public void setTypeId(Integer typeId) {
            this.typeId = typeId;
        }

        public Map<Integer, Object> getCharacteristics() {
           return characteristics;
        }

        public void setCharacteristics(Map<Integer, Object> characteristics) {
            this.characteristics = characteristics;
        }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
