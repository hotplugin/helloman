package eaccount

import org.springframework.dao.DataIntegrityViolationException

class AssignmentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [assignmentInstanceList: Assignment.list(params), assignmentInstanceTotal: Assignment.count()]
    }

    def create() {
        [assignmentInstance: new Assignment(params)]
    }

    def save() {
        def assignmentInstance = new Assignment(params)
        if (!assignmentInstance.save(flush: true)) {
            render(view: "create", model: [assignmentInstance: assignmentInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'assignment.label', default: 'Assignment'), assignmentInstance.id])
        redirect(action: "show", id: assignmentInstance.id)
    }

    def show(Long id) {
        def assignmentInstance = Assignment.get(id)
        if (!assignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'assignment.label', default: 'Assignment'), id])
            redirect(action: "list")
            return
        }

        [assignmentInstance: assignmentInstance]
    }

    def edit(Long id) {
        def assignmentInstance = Assignment.get(id)
        if (!assignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'assignment.label', default: 'Assignment'), id])
            redirect(action: "list")
            return
        }

        [assignmentInstance: assignmentInstance]
    }

    def update(Long id, Long version) {
        def assignmentInstance = Assignment.get(id)
        if (!assignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'assignment.label', default: 'Assignment'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (assignmentInstance.version > version) {
                assignmentInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                    [message(code: 'assignment.label', default: 'Assignment')] as Object[],
                          "Another user has updated this Assignment while you were editing")
                render(view: "edit", model: [assignmentInstance: assignmentInstance])
                return
            }
        }

        assignmentInstance.properties = params

        if (!assignmentInstance.save(flush: true)) {
            render(view: "edit", model: [assignmentInstance: assignmentInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'assignment.label', default: 'Assignment'), assignmentInstance.id])
        redirect(action: "show", id: assignmentInstance.id)
    }

    def delete(Long id) {
        def assignmentInstance = Assignment.get(id)
        if (!assignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'assignment.label', default: 'Assignment'), id])
            redirect(action: "list")
            return
        }

        try {
            assignmentInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'assignment.label', default: 'Assignment'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'assignment.label', default: 'Assignment'), id])
            redirect(action: "show", id: id)
        }
    }

    def myAssShow(){


        println authenticatedUser.student.assignment.name
        def assignmentInstance = Assignment.get(authenticatedUser.student.assignment.id)
        if (!assignmentInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'assignment.label', default: 'Assignment'), id])
            redirect(action: "myAssShow")
            return
        }
             render(view: "myAssignment", model: [assignmentInstance: assignmentInstance])
//        render(view: "myAssignment")
    }
}
