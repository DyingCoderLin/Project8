import React, { useState } from 'react';
import { Image,StyleSheet, View, TextInput, Button, Text,TouchableOpacity,ActionSheetAndroid } from 'react-native';
import LinearGradient from 'react-native-linear-gradient';
import CheckBox from '@react-native-community/checkbox';
import { Picker } from '@react-native-picker/picker';
import EventEdit from '../component/EventEdit';
import DateTimePicker from '@react-native-community/datetimepicker';
import AsyncStorage from "@react-native-community/async-storage";
import axios from "axios";

const AddScreen = ({ navigation }) => {
  const handleFinish = () => {
    // Implement your login logic here
    AsyncStorage.getItem('eventtoSave', (error, result) => {
      if (error) {
        // 处理错误
        console.error('Error reading from AsyncStorage:', error);
      } else {
        // 将字符串转换回对象
        const eventtoSave = JSON.parse(result);
        console.log('Event loaded from AsyncStorage:', eventtoSave);
        // 使用 eventtoSave 对象
        axios({
          method: 'post',
          url: 'http://192.168.173.144:8080/changeEventInfo',
          // url: 'https://mock.apifox.com/m1/4226545-3867488-default/changeEventInfo',
          // headers: {
          //   'User-Agent': 'Apifox/1.0.0 (https://apifox.com)'
          // },
          data:
            eventtoSave

        }).then(
            response => {
              // 检查响应状态码
              if (response.status === 200) {
                // 假设服务器在成功时返回状态码200
                navigation.navigate('Day');
              } else {
                // 如果状态码不是200，打印错误信息
                console.error('Error: Response status is not 200', response.status);
              }
            }
        ).catch(error => {
          console.error('Error fetching data:', error);
        });
      }
    });
  };

  return (
  <LinearGradient colors={['#72C4FF80', '#FF9E9E80']} style={styles.container}>
      <View style={styles.header}>
        <TouchableOpacity style={styles.backButton} onPress={() => navigation.goBack()}>
            <Text style={{fontSize:12,color:'white'}}>返回</Text>
        </TouchableOpacity>
        <Text style={styles.title}>新建事项</Text>
        <View style={{ width: 48 }} />
      </View>

      <EventEdit navigation={navigation} isEdit={true}/>

      <View style={styles.buttonContainer}>
        <TouchableOpacity style={styles.button} onPress={handleFinish}>
            <Text style={styles.buttonText}>完成</Text>
        </TouchableOpacity>
      </View>

    </LinearGradient>
  );
};

const styles = StyleSheet.create({
  container: {
    height: '100%',
    width: '100%',
    flex: 1,
    justifyContent: 'flex-start',
    alignItems: 'center',
    backgroundColor: '#F0F0F7',
    position: 'relative',
    padding:20,
  },
  header: {
    width: '90%',
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    padding: 10,
  },
  backButton:{
    backgroundColor: '#002FA7', // 按钮背景颜色
    width: 50, // 按钮宽度
    height: 30, // 按钮高度
    borderRadius: 5, // 设置圆角
    justifyContent: 'center',
    alignItems: 'center',
    underlayColor: '#000F37',
  },
  title: {
    fontSize: 24,
    color: '#002FA7',
    fontWeight: 'bold',
  },

  buttonContainer: {
    width: '100%',
    marginVertical: 10,
    borderRadius: 10,
    justifyContent: 'center',
    alignItems: 'center',
  },
  button: {
    backgroundColor: '#002FA7', // 按钮背景颜色
    width: '90%', // 按钮宽度
    height: 45, // 按钮高度
    borderRadius: 10, // 设置圆角
    justifyContent: 'center',
    alignItems: 'center',
    underlayColor: '#000F37',
  },
  buttonText: {
    color: '#FFFFFF', // 文本颜色
    fontSize: 16, // 文本大小
    fontWeight: 'bold',
  },
  footerText: {
    marginTop: 20,
    color: '#000F37',
  },

});

export default AddScreen;