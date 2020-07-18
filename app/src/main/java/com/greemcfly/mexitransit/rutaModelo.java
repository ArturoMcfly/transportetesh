package com.greemcfly.mexitransit;

public class rutaModelo {
    private String ruta, descripcion;
    private int imgRuta;

    public rutaModelo(String ruta) {
        this.ruta = ruta;
    }

    public rutaModelo(String ruta, String descripcion, int imgRuta) {
        this.ruta = ruta;
        this.descripcion = descripcion;
        this.imgRuta = imgRuta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImgRuta() {
        return imgRuta;
    }

    public void setImgRuta(int imgRuta) {
        this.imgRuta = imgRuta;
    }
}
