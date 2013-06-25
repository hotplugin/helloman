package eaccount

class StudentClass {
    String name;
    Date created = new Date();
    Boolean active=true;
    static hasMany=[students:Student]
    static mappedBy=[students:"studentClass"]
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
