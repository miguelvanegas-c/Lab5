package edu.eci.cvds.Labtools.dto;


public class UserDTO {
    private String name;
    private boolean rol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserDTO userDTO) {
            return name.equals(userDTO.name) && rol == userDTO.rol;
        }
        return false;
    }
}