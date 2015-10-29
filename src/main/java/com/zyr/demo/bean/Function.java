package com.zyr.demo.bean;


import java.io.Serializable;

public class Function implements Serializable {
    private static final long serialVersionUID = -6781736874719042781L;

    private String id;

    private String funcCode;

    private String funcName;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Function) {
            Function func = (Function) obj;
            if (func.getId().equals(this.getId())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }
}
