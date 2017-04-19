package com.biz.service;

import com.biz.vo.Student;
import redis.clients.jedis.Jedis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/4/18.
 */
public class StudentService {
    private static final String HOST = "localhost";
    private static Jedis jedis;

    static {
        jedis = new Jedis(HOST);
    }

    /**
     * 增加学生
     *
     * @param student
     * @return
     */
    public int addStudent(Student student) {
        String hashKey = getHashKey(student.getId());
        if (jedis.exists(hashKey)) {//学生已存在
            return 0;
        } else {
            saveToRedis(student, hashKey);
            jedis.zadd("student_number",student.getAvgscore(), student.getId());//将avgscore和id存入SORTEDSET
            return 1;
        }
    }

    /**
     * 删除一个学生信息
     *
     * @param id
     * @return
     */
    public Long deleteStudent(String id) {
        jedis.zrem("student_number", id);
        return jedis.del(getHashKey(id));
    }
    /**
     * 获取10条数据
     * @param cur_page
     * @return
     * @throws ParseException
     */
    public List<Student> getOnePage(int cur_page) throws ParseException {
        List<Student> studentList = new LinkedList<Student>();
        Set<String> id_set = jedis.zrevrange("student_number", (cur_page - 1) * 10, cur_page * 10 - 1);
        for (String id : id_set) {
            studentList.add(getById(id));
        }
        return studentList;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotalPage() {
        int len = jedis.zcard("student_number").intValue();
        if(len%10 == 0) {
            return len/10;
        } else {
            return len/10+1;
        }
    }
    /**
     * 修改学生信息
     *
     * @param student
     */
    public void updateStudent(Student student) {
        saveToRedis(student, getHashKey(student.getId()));
    }

    /**
     * 通过id获取学生
     *
     * @param id
     * @return
     * @throws ParseException
     */
    public Student getById(String id) throws ParseException {
        String key = getHashKey(id);
        Student student = new Student();
        student.setId(jedis.hget(key, "id"));
        student.setName(jedis.hget(key, "name"));
        student.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(jedis.hget(key, "birthday")));
        student.setDescription(jedis.hget(key, "description"));
        student.setAvgscore(Integer.parseInt(jedis.hget(key, "avgscore")));
        return student;
    }
    /**
     * 保存学生信息到redis
     *
     * @param student
     * @param hashKey
     */
    private void saveToRedis(Student student, String hashKey) {

        jedis.hset(hashKey, "id", student.getId());
        jedis.hset(hashKey, "name", student.getName());
        jedis.hset(hashKey, "birthday", new SimpleDateFormat("yyyy-MM-dd").format(student.getBirthday()));
        jedis.hset(hashKey, "description", student.getDescription());
        jedis.hset(hashKey, "avgscore", String.valueOf(student.getAvgscore()));
    }

    /**
     * 获取hash表的key
     *
     * @param id
     * @return
     */
    private String getHashKey(String id) {
        return "student_info_" + id;
    }
}
