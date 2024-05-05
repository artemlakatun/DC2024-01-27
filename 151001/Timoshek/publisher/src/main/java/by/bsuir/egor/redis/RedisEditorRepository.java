package by.bsuir.egor.redis;

import by.bsuir.egor.Entity.Editor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisEditorRepository {
    @Autowired
    private RedisTemplate template;
    private static final String HASH_KEY = "Editor";


    public Editor add(Editor editor){
        try {
            template.opsForHash().put(HASH_KEY, editor.getId(), editor);
            template.expire(HASH_KEY,10, TimeUnit.SECONDS);
            return editor;
        }catch (Exception e){
            return null;
        }
    }

    public Editor update(Editor editor){
        Optional<Editor> currentUser = getById(editor.getId());
        if(currentUser.isPresent()){
            template.opsForHash().put(HASH_KEY, editor.getId(), editor);

            template.expire(HASH_KEY,10, TimeUnit.SECONDS);
            return editor;
        }else{
            return null;
        }
    }

    public void delete(long id){
        template.opsForHash().delete(HASH_KEY,id);
    }

    public List<Editor> getAll(){
        List<Editor> Editor = new ArrayList<>();
        List<Object> data = template.opsForHash().values(HASH_KEY);
        for(Object obj : data){
            Editor.add((Editor) obj);
        }
        return Editor;
    }

    public Optional<Editor> getById(long id){
        Object User = template.opsForHash().get(HASH_KEY,id);
        return Optional.ofNullable((Editor)User);
    }
}
