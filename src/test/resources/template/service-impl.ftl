package ${basePackage}.${modelName}.service;

import ${basePackage}.${modelName}.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.${modelName}.domain.model.${modelNameUpperCamel};
import ${basePackage}.core.lang.PageQuery;
import ${basePackage}.core.lang.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ${modelNameUpperCamel}ServiceImpl implements ${modelNameUpperCamel}Service {

    private final ${modelNameUpperCamel}Mapper ${modelNameUpperCamel}Mapper;

    @Override
    public ${modelNameUpperCamel} findByState(String state) {
        return ${modelName}Mapper.findByState(state);
    }

    @Override
    public ${modelNameUpperCamel} insert(${modelNameUpperCamel} ${modelName}) {
        ${modelName}Mapper.insert(${modelName});
        return entity;
    }

    @Override
    public ${modelNameUpperCamel} update(Long id, ${modelNameUpperCamel} ${modelName}) {
        ${modelName}Mapper.update(${modelName});
        return entity;
    }

    @Override
    public ${modelNameUpperCamel} findById(Long id) {
        return ${modelName}Mapper.findById(id);
    }

    @Override
    public void delete(Long id) {
        ${modelName}Mapper.deleteById(id);
    }

    @Override
    public List<${modelNameUpperCamel}> findAll(Query query) {
        return ${modelName}Mapper.findAll(query);
    }

    @Override
    public List<${modelNameUpperCamel}> findForPage(PageQuery pageQuery) {
        return ${modelName}Mapper.findAll(pageQuery);
    }

    @Override
    public ${modelNameUpperCamel} publish(Long id, Boolean flag) {
        return null;
    }
}
