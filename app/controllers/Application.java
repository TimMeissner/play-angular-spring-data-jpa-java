package controllers;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import org.h2.engine.Database;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.IOException;
import java.util.List;

import static play.libs.Json.fromJson;
import static play.libs.Json.toJson;

/**
 * The main set of web services.
 */
@Named
@Singleton
public class Application extends Controller {

    private final CategoriesRepository categoriesRepository;
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    @Inject
    public Application(final CategoriesRepository categoriesRepository, final NoteRepository noteRepository, final UserRepository userRepository) {
        this.categoriesRepository = categoriesRepository;
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result getUser(long id) {
        User user = userRepository.findOne(id);
        return ok(toJson(user));
    }

    public Result addUser() {
        Http.RequestBody body = request().body();
        return ok("Got json: " + body.asJson());

        /*User user = Form.form(User.class).bindFromRequest().get();
        user.save();
        return redirect(routes.Application.index());*/
    }

    public Result getNotes() {
        List<Note> notes = (List<Note>) noteRepository.findAll();
        return ok(toJson(notes));
    }

    public Result getCategories() {
        List<Categories> categories = (List<Categories>) categoriesRepository.findAll();
        return ok(toJson(categories));
    }

    public Result getUsers() {
        List<User> persons = (List<User>) userRepository.findAll();

        return ok(toJson(persons));
    }

    public Result addNote() {
        Http.RequestBody body = request().body();
        Note note = Note.fromJson(body.asJson());
        noteRepository.save(note);
        return ok("Got json: " + body.asJson());
    }

    public Result editNote(Long id) {
         Note note = fromJson(request().body().asJson(), Note.class);
         noteRepository.save(note);
        return ok(toJson(note));
    }

    public Result getNote(long id) {
        Note note =  noteRepository.findOne(id);
        return ok(toJson(note));
    }
}
