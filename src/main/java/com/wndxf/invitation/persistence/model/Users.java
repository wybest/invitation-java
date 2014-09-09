package com.wndxf.invitation.persistence.model;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Date;


public class Users implements Serializable {
	private Integer id;
	private String username;
	private String password;
	private Date createTime;
	private Date lastTime;
	private Integer vipNum;
	private Integer isPay;
	private String email;
	private Integer isPhone;
	private Integer isPc;
	private String fontFamily;
	private String advert;
	private Integer isAdvert;
	private String extension;
	private String specialName;
	private String title1;
	private String title2;
	private String title3;
	private String title4;
	private String title5;
	private Integer showNum;
	private Integer adminId;
	private Integer isConfirm;
	private String isShow;
	private String style;
	private String mould;
	private String pcMould;
	private String music;
	private String man;
	private String women;
	private String warnTime;
	private String house;
	private String address;
	private String image;
	private String message;
	private String coordinate;
	private String showTime;
	private String miniTime;
	private String bigImage;
	private String title;
	private String bigTitle;
	private String weiXin;
	private String video;
    private String background;

	public Integer getId() {
 		return this.id;
	}
	
	public void setId(Integer id) {
 		this.id = id;
	}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPassword() {
 		return this.password;
	}
	
	public void setPassword(String password) {
 		this.password = password;
	}

	public Date getCreateTime() {
 		return this.createTime;
	}
	
	public void setCreateTime(Date createTime) {
 		this.createTime = createTime;
	}

	public Date getLastTime() {
 		return this.lastTime;
	}
	
	public void setLastTime(Date lastTime) {
 		this.lastTime = lastTime;
	}

	public Integer getVipNum() {
 		return this.vipNum;
	}
	
	public void setVipNum(Integer vipNum) {
 		this.vipNum = vipNum;
	}

	public Integer getIsPay() {
 		return this.isPay;
	}
	
	public void setIsPay(Integer isPay) {
 		this.isPay = isPay;
	}

	public String getEmail() {
 		return this.email;
	}
	
	public void setEmail(String email) {
 		this.email = email;
	}

	public Integer getIsPhone() {
 		return this.isPhone;
	}
	
	public void setIsPhone(Integer isPhone) {
 		this.isPhone = isPhone;
	}

	public Integer getIsPc() {
 		return this.isPc;
	}
	
	public void setIsPc(Integer isPc) {
 		this.isPc = isPc;
	}

	public String getFontFamily() {
 		return this.fontFamily;
	}
	
	public void setFontFamily(String fontFamily) {
 		this.fontFamily = fontFamily;
	}

	public String getAdvert() {
 		return this.advert;
	}
	
	public void setAdvert(String advert) {
 		this.advert = advert;
	}

	public Integer getIsAdvert() {
 		return this.isAdvert;
	}
	
	public void setIsAdvert(Integer isAdvert) {
 		this.isAdvert = isAdvert;
	}

	public String getExtends() {
 		return this.extension;
	}
	
	public void setExtends(String extension) {
 		this.extension = extension;
	}

	public String getSpecialName() {
 		return this.specialName;
	}
	
	public void setSpecialName(String specialName) {
 		this.specialName = specialName;
	}

	public String getTitle1() {
 		return this.title1;
	}
	
	public void setTitle1(String title1) {
 		this.title1 = title1;
	}

	public String getTitle2() {
 		return this.title2;
	}
	
	public void setTitle2(String title2) {
 		this.title2 = title2;
	}

	public String getTitle3() {
 		return this.title3;
	}
	
	public void setTitle3(String title3) {
 		this.title3 = title3;
	}

	public String getTitle4() {
 		return this.title4;
	}
	
	public void setTitle4(String title4) {
 		this.title4 = title4;
	}

	public String getTitle5() {
 		return this.title5;
	}
	
	public void setTitle5(String title5) {
 		this.title5 = title5;
	}

	public Integer getShowNum() {
 		return this.showNum;
	}
	
	public void setShowNum(Integer showNum) {
 		this.showNum = showNum;
	}

	public Integer getAdminId() {
 		return this.adminId;
	}
	
	public void setAdminId(Integer adminId) {
 		this.adminId = adminId;
	}

	public Integer getIsConfirm() {
 		return this.isConfirm;
	}
	
	public void setIsConfirm(Integer isConfirm) {
 		this.isConfirm = isConfirm;
	}

	public String getIsShow() {
 		return this.isShow;
	}
	
	public void setIsShow(String isShow) {
 		this.isShow = isShow;
	}

	public String getStyle() {
 		return this.style;
	}
	
	public void setStyle(String style) {
 		this.style = style;
	}

	public String getMould() {
 		return this.mould;
	}
	
	public void setMould(String mould) {
 		this.mould = mould;
	}

	public String getPcMould() {
 		return this.pcMould;
	}
	
	public void setPcMould(String pcMould) {
 		this.pcMould = pcMould;
	}

	public String getMusic() {
 		return this.music;
	}
	
	public void setMusic(String music) {
 		this.music = music;
	}

	public String getMan() {
 		return this.man;
	}
	
	public void setMan(String man) {
 		this.man = man;
	}

	public String getWomen() {
 		return this.women;
	}
	
	public void setWomen(String women) {
 		this.women = women;
	}

	public String getWarnTime() {
 		return this.warnTime;
	}
	
	public void setWarnTime(String warnTime) {
 		this.warnTime = warnTime;
	}

	public String getHouse() {
 		return this.house;
	}
	
	public void setHouse(String house) {
 		this.house = house;
	}

	public String getAddress() {
 		return this.address;
	}
	
	public void setAddress(String address) {
 		this.address = address;
	}

	public String getImage() {
 		return this.image;
	}
	
	public void setImage(String image) {
 		this.image = image;
	}

	public String getMessage() {
 		return this.message;
	}
	
	public void setMessage(String message) {
 		this.message = message;
	}

	public String getCoordinate() {
 		return this.coordinate;
	}
	
	public void setCoordinate(String coordinate) {
 		this.coordinate = coordinate;
	}

	public String getShowTime() {
 		return this.showTime;
	}
	
	public void setShowTime(String showTime) {
 		this.showTime = showTime;
	}

	public String getMiniTime() {
 		return this.miniTime;
	}
	
	public void setMiniTime(String miniTime) {
 		this.miniTime = miniTime;
	}

	public String getBigImage() {
 		return this.bigImage;
	}
	
	public void setBigImage(String bigImage) {
 		this.bigImage = bigImage;
	}

	public String getTitle() {
 		return this.title;
	}
	
	public void setTitle(String title) {
 		this.title = title;
	}

	public String getBigTitle() {
 		return this.bigTitle;
	}
	
	public void setBigTitle(String bigTitle) {
 		this.bigTitle = bigTitle;
	}

	public String getWeiXin() {
 		return this.weiXin;
	}
	
	public void setWeiXin(String weiXin) {
 		this.weiXin = weiXin;
	}

	public String getVideo() {
 		return this.video;
	}
	
	public void setVideo(String video) {
 		this.video = video;
	}

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
