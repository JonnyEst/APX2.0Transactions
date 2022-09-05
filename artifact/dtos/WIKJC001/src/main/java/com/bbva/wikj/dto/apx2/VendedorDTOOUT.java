package com.bbva.wikj.dto.apx2;

public class VendedorDTOOUT {

    private static final long serialVersionUID = 2931699728946643245L;

    private String nombre;
    private String telefono;
    private String documento;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "VendedorDTOOUT{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }
}
