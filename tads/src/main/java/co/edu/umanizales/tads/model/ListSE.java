package co.edu.umanizales.tads.model;

import lombok.Data;

@Data
public class ListSE {
    private Node head;


    public void add(Kid kid){
        if(head != null){
            Node temp = head;
            while(temp.getNext() !=null)
            {
                temp = temp.getNext();
            }
            /// Parado en el último
            Node newNode = new Node(kid);
            temp.setNext(newNode);
        }
        else {
            head = new Node(kid);
        }
    }


    public void addToStart(Kid kid){
        if(head !=null)
        {
            Node newNode = new Node(kid);
            newNode.setNext(head);
            head = newNode;
        }
        else {
            head = new Node(kid);
        }
    }

    // Metodo remover por id
    public void removeById(String id) {
        if (head != null) {
            Node temp = head;
            if (head.getData().getIdentification().equals(id)) {
                head = head.getNext();
            } else {
                while (!temp.getNext().getData().getIdentification().equals(id)) {
                    temp = temp.getNext();
                }
                temp.setNext(temp.getNext().getNext());
            }
        }
    }

    // Metodo Add niño por posicion
    public void addKidXPos(Kid kid, int pos) {
        if (head != null) {
            Node temp = head;
            int contador = 0;
            while (contador < pos-2) {
                temp = temp.getNext();
                contador = contador+1;
            }
            Node newNode = new Node(kid);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
        } else {
            head = new Node(kid);
        }
    }
// Metodo eliminar niño
    public void deleteKid(String id){
        Node temp = head;
        Node empt = null;
        if(temp != null && temp.getData().getIdentification().equals(id)){
            head = temp.getNext();
            return;
        }
        while (temp!=null && !temp.getNext().getData().getIdentification().equals(id)){
            empt = temp;
            temp = temp.getNext();
        }
        if(temp == null){
            return;
        }
        empt.setNext(temp.getNext());
    }


    // Metodo Ordenar por genero
    public void OrdenByGender() {
        ListSE listSE1 = new ListSE();

        int sum=0;
        Node temp = head;
        while (temp != null && temp.getNext().getData().getGender() == 'F') {
            listSE1.addToStart(temp.getData());
            temp.getNext();
        }
        while (temp != null && temp.getNext().getData().getGender()=='M'){
            sum= sum +2;
            listSE1.addKidXPos(temp.getData(),sum);
            temp.getNext();
        }
        this.head = listSE1.getHead();
    }

    //Metodo para perder posiciones
    public void losePositions(String id, int lose){
        Node temp = head;
        lose = 0;
        int sum = 0;
        ListSE listSE1 = new ListSE();
        if(head !=null){
            while(temp !=null && !temp.getData().getIdentification().equals(id)){
                listSE1.add(temp.getData());
                temp.getNext();
            }
        }
        sum = lose+ getPostbyId(id);
        listSE1.addKidXPos(getKidById(id),sum);
    }
    //Metodo para obtener posiciones x Id
    public int getPostbyId(String id){
        Node temp = head;
        int acum= 0;
        if (head !=null) {
            while (temp != null && !temp.getData().getIdentification().equals(id)){
                acum = acum+1;
                temp.getNext();
                return acum;
            }
        }
        return acum;
    }

    // Metodo para obtener la informacion por Id y que retorne la informacion del niño
    public Kid getKidById(String id){
        Node temp = head;
        if (head != null){
            while (temp != null){
                temp.getNext();
                while (!temp.getData().getIdentification().equals(id)){
                    temp.getNext();
                }
                    temp.getData();
            }

        }
        Kid kid = new Kid(temp.getData().getIdentification(),temp.getData().getName(),temp.getData().getAge(),temp.getData().getGender(), temp.getData().getLocation());
        return kid;
    }



public int getCountKidsByLocationCode(String code){
        int count = 0;
        if(this.head!=null){
            Node temp = this.head;
            while(temp != null){
                if(temp.getData().getLocation().getCode().equals(code)){
                    count++;
                }
                temp = temp.getNext();
            }
        }
        return count;
}

    public int getDepartmentsByLocationCode(String code){
        int count = 0;
        if(this.head!=null){
            Node temp = this.head;
            while(temp != null){
                if(temp.getData().getLocation().getCode().contains(code)){
                    count++;
                }
                temp = temp.getNext();
            }
        }
        return count;
    }

public void invert(){
        if(this.head !=null){
            ListSE listCp = new ListSE();
            Node temp = this.head;
            while (temp !=null){
                listCp.addToStart(temp.getData());
                temp = temp.getNext();
            }
                this.head = listCp.getHead();
        }
}

public void changeExtremes(){
        if(this.head !=null && this.head.getNext() !=null){
            Node temp = this.head;
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            //temp esta en el ultimo
            Kid copy = this.head.getData();
            this.head.setData(temp.getData());
            temp.setData(copy);
        }
}



}
