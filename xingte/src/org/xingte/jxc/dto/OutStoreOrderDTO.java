package org.xingte.jxc.dto;
import java.util.Date;
public class OutStoreOrderDTO {
    private int id;
    private String outstorenumber;
    private int storeroomkeeperid;
    private String storeroomkeepername;
    private int outstoretype;
    private String outstoretypes;
    private Date outdate;
    private int state;
    private String statename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOutstorenumber() {
		return outstorenumber;
	}
	public void setOutstorenumber(String outstorenumber) {
		this.outstorenumber = outstorenumber;
	}
	public int getStoreroomkeeperid() {
		return storeroomkeeperid;
	}
	public void setStoreroomkeeperid(int storeroomkeeperid) {
		this.storeroomkeeperid = storeroomkeeperid;
	}
	public String getStoreroomkeepername() {
		return storeroomkeepername;
	}
	public void setStoreroomkeepername(String storeroomkeepername) {
		this.storeroomkeepername = storeroomkeepername;
	}
	public int getOutstoretype() {
		return outstoretype;
	}
	public void setOutstoretype(int outstoretype) {
		this.outstoretype = outstoretype;
	}
	public String getOutstoretypes() {
		return outstoretypes;
	}
	public void setOutstoretypes(String outstoretypes) {
		this.outstoretypes = outstoretypes;
	}
	public Date getOutdate() {
		return outdate;
	}
	public void setOutdate(Date outdate) {
		this.outdate = outdate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	@Override
	public String toString() {
		return "OutStoreOrderDTO [id=" + id + ", outstorenumber="
				+ outstorenumber + ", storeroomkeeperid=" + storeroomkeeperid
				+ ", storeroomkeepername=" + storeroomkeepername
				+ ", outstoretype=" + outstoretype + ", outstoretypes="
				+ outstoretypes + ", outdate=" + outdate + ", state=" + state
				+ ", statename=" + statename + "]";
	}
	
}
