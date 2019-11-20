package io.pivotal.pal.tracker;

import javax.lang.model.type.NullType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private  Map<Long,TimeEntry> repo=new HashMap<Long,TimeEntry>();
    private long currentId = 1L;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        timeEntry.setId(currentId);

        repo.put(currentId,timeEntry);
        currentId++;
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return repo.get(id);
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        if(find(id) ==null) return null;

       timeEntry.setId(id);
       repo.replace(id,timeEntry);
       return  timeEntry;
    }

    @Override
    public void delete(long id) {
        repo.remove(id);
        
    }

    @Override
    public List<TimeEntry> list() {

        return new ArrayList<>(repo.values());
    }









}
