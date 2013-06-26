package eaccount

class Assignment {

    String name;
    Date created = new Date();
    Boolean active=true;
//    static belongsTo = Student;
    static hasMany =[students:Student]
    static mappeyBy=[students:"assignment"]
  
    static constraints = {
        name(blank:false)
        students(display:false)
        created(display:false)
        active(display:false)
    }
    String toString(){
         "${name}"
    }
}
