package mvplazic.app;

import org.springframework.stereotype.Service;

import java.util.List;
public interface GItemService {

    List<GroceryItem> findAll();
}
