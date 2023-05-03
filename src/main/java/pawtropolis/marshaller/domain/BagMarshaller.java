package pawtropolis.marshaller.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pawtropolis.game.domain.Bag;
import pawtropolis.game.domain.Item;
import pawtropolis.marshaller.IMarshaller;
import pawtropolis.marshaller.MarshallerGateway;
import pawtropolis.marshaller.MarshallerProvider;
import pawtropolis.persistence.entity.BagVO;
import pawtropolis.persistence.entity.ItemVO;

import java.util.Set;

@Component
public class BagMarshaller implements IMarshaller<Bag,BagVO> {
    private final ApplicationContext ctx;

    @Autowired
    private BagMarshaller(ApplicationContext ctx){
        this.ctx = ctx;
    }
    @Override
    public Bag marshall(BagVO bagVO) {
        Bag bag = new Bag(bagVO.getMaxSlots());
        Set<ItemVO> itemsVO = bagVO.getItems();
        itemsVO.stream().forEach
                (i -> bag.addItem((Item)ctx.getBean(MarshallerGateway.class).marshallVO(i)));
        return bag;
    }
}
