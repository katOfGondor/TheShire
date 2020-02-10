package com.company;

public class InversionOfControl {

    public static void main(String[] args) {
        //The below is an illustration of dependency injection in that we are passing the dependency(Our database down the dependency tree)
        InversionOfControl container = new InversionOfControl();
        User user = container.new User(container.new MySqlDatabase());
        user.add("Katleho");
    }

    public class User{
        Database database;

        public User(Database database){
            this.database = database;
        }

        public void add(String data){

            database.persist(data);
        }
    }

    //An interface to enforce the abstraction of the database objects(Multiple Inheritance)
    public interface Database{

        void persist(String data);

    }



    public class MySqlDatabase implements Database{

        public void persist(String data){

            System.out.println("MySql has persisted "+ data );
        }

    }

    public class OracleDatabase implements Database{

        public void persist(String data){

            System.out.println("Oracle has persisted "+ data );
        }

    }

}


