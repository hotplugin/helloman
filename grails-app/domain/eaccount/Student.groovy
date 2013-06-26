package eaccount

class Student {
    String name;
    Date created = new Date();
    Boolean active=true;
    StudentClass studentClass;
    Assignment assignment;
    static belongsTo = [StudentClass,Assignment];
    static constraints = {
        name(blank:false)
        studentClass(blank:false)
     
        created(display:false)
        active(display:false)
           assignment nullable:true
    }
    String toString(){
         "${name}"
    }
}
