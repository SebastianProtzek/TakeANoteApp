package protzek.sebastian.takeanoteapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import protzek.sebastian.takeanoteapp.room.Note;
import protzek.sebastian.takeanoteapp.room.NoteRepository;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }


    void insert(Note note) {
        repository.insert(note);
    }

    void update(Note note) {
        repository.update(note);
    }

    void delete(Note note) {
        repository.delete(note);
    }

    void deleteAllNotes() {
        repository.deleteAllNotes();
    }

    LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
