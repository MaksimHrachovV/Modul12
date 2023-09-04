package goit.module12.service;


import goit.module12.note.Note;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {

    public static final Map<Long, Note> NOTE_MAP=new HashMap<>();

    private static final AtomicLong ATOMIC_ID=new AtomicLong();


    public Note add(Note note){
           final Long noteId=ATOMIC_ID.incrementAndGet();
            note.setId(noteId);
            note.setTitle("Title "+noteId);
            note.setContent("Content "+noteId);
            NOTE_MAP.put(noteId,note);
        return note;
    }
    public List<Note>listAll(){

        return new ArrayList<>(NOTE_MAP.values());
    }

    public void deleteById(Long id) {
    if (!NOTE_MAP.containsKey(id)){

         throw new NullPointerException("ID not found in base!!!!!");

    }
     NOTE_MAP.remove(id);
    }
    public void update(Note note){
        if (!NOTE_MAP.containsKey(note.getId())){
        throw new NullPointerException("ID not found in base!!!!!");

        }
        NOTE_MAP.put(note.getId(), note);
    }
    public Note getById(Long id){
        if (!NOTE_MAP.containsKey(id)){

        throw new NullPointerException("ID not found in base!!!!!");

        }
        System.out.println("id = " + id);
       return NOTE_MAP.get(id);

    }



}
