package models;

public class Articulos {
    protected String codigo;
    protected String descripcion;
    protected float precioVenta;
    protected int stock;

    public Articulos(String codigo, String descripcion, float precioVenta, int stock){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String incrementoStock(int cantidad){
        int nuevaCantidad = cantidad + getStock();
        setStock(nuevaCantidad);
        return "Stock nuevo: "+nuevaCantidad;
    }

    public String decrementoStock(int cantidad){
        int nuevaCantidad = cantidad - getStock();
        if(nuevaCantidad >= 0){
            setStock(nuevaCantidad);
            return "Stock nuevo: "+nuevaCantidad;
        }
        return "No es posible ya que no hay mas stock";
    }
}
