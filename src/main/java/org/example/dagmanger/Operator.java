package org.example.dagmanger;

import lombok.Data;
import org.example.dagmanger.commond.Command;

import java.util.Iterator;
import java.util.List;

@Data
public class Operator {
    private long id;
    private String name;
    private Dag dag;
    private Command command ;
    private short retries;
    private List<Operator> depends;

    public void setDepend(Operator operator){
        depends.add(operator);
    }

    public Iterator<Operator> iter(){
        return depends.iterator();
    }

}
