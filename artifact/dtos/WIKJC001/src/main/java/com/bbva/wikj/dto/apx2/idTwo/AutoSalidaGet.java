package com.bbva.wikj.dto.apx2.idTwo;

import com.bbva.wikj.dto.apx2.VendedorDTO;

public class AutoSalidaGet {

    private Integer idProduct;
    private String marca;
    private String modelo;
    private Integer año;
    private String color;
    private Integer puertas;
    private String trasmision;
    private String kilometros;
    private VendedorDTO vendedorDTO;
    private String precio;
    private Integer descuentoCompraSinIVA;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPuertas() {
        return puertas;
    }

    public void setPuertas(Integer puertas) {
        this.puertas = puertas;
    }

    public String getTrasmision() {
        return trasmision;
    }

    public void setTrasmision(String trasmision) {
        this.trasmision = trasmision;
    }

    public String getKilometros() {
        return kilometros;
    }

    public void setKilometros(String kilometros) {
        this.kilometros = kilometros;
    }

    public VendedorDTO getVendedorDTO() {
        return vendedorDTO;
    }

    public void setVendedorDTO(VendedorDTO vendedorDTO) {
        this.vendedorDTO = vendedorDTO;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Integer getDescuentoCompraSinIVA() {
        return descuentoCompraSinIVA;
    }

    public void setDescuentoCompraSinIVA(Integer descuentoCompraSinIVA) {
        this.descuentoCompraSinIVA = descuentoCompraSinIVA;
    }

    @Override
    public String toString() {
        return "AutoSalidaGet{" +
                "idProduct=" + idProduct +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + año +
                ", color='" + color + '\'' +
                ", puertas=" + puertas +
                ", trasmision='" + trasmision + '\'' +
                ", kilometros='" + kilometros + '\'' +
                ", vendedorDTO=" + vendedorDTO +
                ", precio='" + precio + '\'' +
                ", descuentoCompraSinIVA=" + descuentoCompraSinIVA +
                '}';
    }
}
