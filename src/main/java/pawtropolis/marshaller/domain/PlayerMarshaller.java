package pawtropolis.marshaller.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pawtropolis.game.domain.Item;
import pawtropolis.game.domain.Player;
import pawtropolis.marshaller.IMarshaller;
import pawtropolis.marshaller.MarshallerGateway;
import pawtropolis.persistence.entity.PlayerVO;

@Component
public class PlayerMarshaller implements IMarshaller<Player,PlayerVO> {
    private final ApplicationContext ctx;

    @Autowired
    private PlayerMarshaller(ApplicationContext ctx){
        this.ctx = ctx;
    }
    @Override
    public Player marshall(PlayerVO playerVO){
        Player player = ctx.getBean(Player.class);
        playerVO.getBag().getItems().stream().
                forEach(i -> player.addItemToBag((Item)ctx.getBean(MarshallerGateway.class).marshallVO(i)));
        return player;
    }
}
