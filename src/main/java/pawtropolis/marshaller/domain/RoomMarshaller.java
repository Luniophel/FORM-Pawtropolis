package pawtropolis.marshaller.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pawtropolis.game.domain.Item;
import pawtropolis.map.domain.Room;
import pawtropolis.marshaller.IMarshaller;
import pawtropolis.marshaller.MarshallerGateway;
import pawtropolis.persistence.entity.ItemVO;
import pawtropolis.persistence.entity.RoomVO;

import java.util.Set;

@Component
public class RoomMarshaller implements IMarshaller<Room, RoomVO> {
    private final ApplicationContext ctx;

    @Autowired
    private RoomMarshaller(ApplicationContext ctx){
        this.ctx = ctx;
    }
    @Override
    public Room marshall(RoomVO roomVO){
        Room room = new Room(roomVO.getName());
        room.setId(roomVO.getId());
        Set<ItemVO> itemsVO = roomVO.getItems();
        itemsVO.stream().forEach
                (i -> room.addItem((Item)ctx.getBean(MarshallerGateway.class).marshallVO(i)));
        roomVO.getAdjacentRooms().
                forEach((k,v)-> room.linkRoom( (Room)ctx.getBean(MarshallerGateway.class).marshallVO(v),k));
        return room;
    }
}
