package co.test.testpro.util;

import co.test.testpro.domain.Todo;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class FileHandler {

    public Todo parseFileInfo(
            Integer todoIds,
            MultipartFile multipartFile
    ) throws Exception{

        //반환을 할 파일 리스트
        Todo todo = new Todo();

        if(multipartFile.isEmpty()){
            return null;
        }

        //파일을 업로드 한 날짜로 바꾸어서 저장
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String current_date = simpleDateFormat.format(new Date());

        //프로젝트 폴더에 저장 하기 위해 절대경로를 설정
        String absoutePath = new File("").getAbsolutePath() + "\\";

        //경로를 지정하고 그곳에다가 저장
        String path = "images/" + current_date;
        File file = new File(path);

        //저장할 위치의 디렉토리가 존재하지 않을 경우
        if(!file.exists()){
            //mkdir() 함수와 다른 점은 상위가 존재하지 않을 때 그것까지 생성
            file.mkdirs();
        }

        //파일 가공

        //파일이 비어 있지 않을 대 작업을 시작해야 오류가 나지 ㅇ낳음
        if(!multipartFile.isEmpty()){
            //jpeg,png,gif만 처리 예정
            String contentType = multipartFile.getContentType();
            String originalFileExtenstion;
            //확장자가 없으면 에러 처리
            if(ObjectUtils.isEmpty(contentType)){
                return null;
            }
            else{
                if(contentType.contains("image/jpeg")){
                    originalFileExtenstion = ".jpg";
                }else if(contentType.contains("image/png")){
                    originalFileExtenstion = ".png";
                }else if(contentType.contains("image/git")){
                    originalFileExtenstion = ".gif";
                }else{
                    return null;
                }
            }
            //각 이름은 겹치면 안되므로 초까지 동원하여 지정
            String new_file_name = Long.toString(System.nanoTime()) + originalFileExtenstion;
            //생성 후 리스트에 추가
            todo = Todo.builder()
                    .id(todoIds)
                    .oriname(multipartFile.getOriginalFilename())
                    .path(path + "/" + new_file_name)
                    .size(multipartFile.getSize())
                    .build();

            file = new File(absoutePath + path + "/" + new_file_name);
            multipartFile.transferTo(file);
        }

        return todo;
    }
}
