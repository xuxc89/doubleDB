package cn.example.doubleDB.dao.db1.gen.entity;

public class Role {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.id
     *
     * @mbg.generated Tue Jul 04 16:19:25 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.name
     *
     * @mbg.generated Tue Jul 04 16:19:25 CST 2017
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.del_flg
     *
     * @mbg.generated Tue Jul 04 16:19:25 CST 2017
     */
    private Integer delFlg;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbg.generated Tue Jul 04 16:19:25 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbg.generated Tue Jul 04 16:19:25 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.name
     *
     * @return the value of role.name
     *
     * @mbg.generated Tue Jul 04 16:19:25 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.name
     *
     * @param name the value for role.name
     *
     * @mbg.generated Tue Jul 04 16:19:25 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.del_flg
     *
     * @return the value of role.del_flg
     *
     * @mbg.generated Tue Jul 04 16:19:25 CST 2017
     */
    public Integer getDelFlg() {
        return delFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.del_flg
     *
     * @param delFlg the value for role.del_flg
     *
     * @mbg.generated Tue Jul 04 16:19:25 CST 2017
     */
    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }
}