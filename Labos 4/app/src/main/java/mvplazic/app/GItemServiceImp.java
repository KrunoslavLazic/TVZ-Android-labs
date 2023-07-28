package mvplazic.app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GItemServiceImp implements GItemService{

    private GItemRepository gItemRepository;

    public GItemServiceImp(GItemRepository gItemRepository) {
        this.gItemRepository = gItemRepository;
    }

    @Override
    public List<GroceryItem> findAll() {
        return new ArrayList<>(gItemRepository.findAll());
    }
}
