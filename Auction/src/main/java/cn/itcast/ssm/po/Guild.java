package cn.itcast.ssm.po;

public class Guild {
    private Integer id;

    private String guildName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName == null ? null : guildName.trim();
    }
}