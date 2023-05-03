package pawtropolis.marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pawtropolis.command.domain.*;
import pawtropolis.marshaller.domain.BagMarshaller;
import pawtropolis.marshaller.domain.ItemMarshaller;
import pawtropolis.marshaller.domain.PlayerMarshaller;
import pawtropolis.marshaller.domain.RoomMarshaller;
import pawtropolis.persistence.entity.*;


import java.util.HashMap;
import java.util.Map;

@Component
public class MarshallerProvider {
    private final Map<Class<? extends IMarshallizable>,IMarshaller<?,?>> marshallers;

    @Autowired
    private MarshallerProvider(ApplicationContext ctx){

        this.marshallers = new HashMap<>();

        marshallers.put(BagVO.class, ctx.getBean(BagMarshaller.class));
        marshallers.put(ItemVO.class, ctx.getBean(ItemMarshaller.class));
        marshallers.put(PlayerVO.class, ctx.getBean(PlayerMarshaller.class));
        marshallers.put(RoomVO.class, ctx.getBean(RoomMarshaller.class));
    }

    protected IMarshaller<?, ?> getMarshaller(Class<? extends IMarshallizable> VO){
            return marshallers.get(VO);
    }
}

