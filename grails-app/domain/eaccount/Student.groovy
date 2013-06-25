package eaccount

class Student {
    String name;
    Date created = new Date();
    Boolean active=true;
    StudentClass studentClass;
    static belongsTo = StudentClass;
    static constraints = {
        name(blank:false)
        studentClass(blank:false)
        created(display:false)
        active(display:false)
    }
    String toString(){
         "${name}"
    }
}
