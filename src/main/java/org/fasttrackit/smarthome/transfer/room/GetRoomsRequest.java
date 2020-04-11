package org.fasttrackit.smarthome.transfer.room;

public class GetRoomsRequest {

    private String partialName;


    public String getPartialName() {
        return partialName;
    }



        public void setPartialName(String partialName) {
        this.partialName = partialName;
    }

    @Override
    public String toString() {
        return "GetRoomsRequest{" +
                "partialName='" + partialName + '\'' +
                '}';
    }
}
