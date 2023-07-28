package mvplazic.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/gitems")
@RestController
@CrossOrigin(origins = "*")
public class GitemRestController {

    private GItemService gItemService;

    @Autowired
    public GitemRestController(GItemService gItemService) {
        this.gItemService = gItemService;
    }

    @GetMapping
    public List<GroceryItem> getAllGItems(){
        return gItemService.findAll();
    }

}
