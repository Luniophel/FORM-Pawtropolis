package pawtropolis.marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class MarshallerGateway {

    private final ApplicationContext ctx;

    @Autowired
    private MarshallerGateway(ApplicationContext ctx){
        this.ctx = ctx;
    }

    //TODO aggiungere MarshallerProvider con autowired
    public IMarshallized marshallVO(IMarshallizable VO){
        return (IMarshallized) ctx.getBean(MarshallerProvider.class).getMarshaller(VO.getClass()).marshall(VO);
    }
}