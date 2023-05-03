package pawtropolis.marshaller.domain;

import org.springframework.stereotype.Component;
import pawtropolis.game.domain.Item;
import pawtropolis.marshaller.IMarshaller;
import pawtropolis.persistence.entity.ItemVO;

@Component
public class ItemMarshaller implements IMarshaller<Item,ItemVO> {
    @Override
    public Item marshall(ItemVO itemVO) {
        Item item = new Item(itemVO.getName(), itemVO.getDescription(), itemVO.getRequiredSlots());
        item.setId(itemVO.getId());
        return item;
    }
}
